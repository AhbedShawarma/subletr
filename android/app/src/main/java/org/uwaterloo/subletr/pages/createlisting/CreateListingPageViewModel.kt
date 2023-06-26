package org.uwaterloo.subletr.pages.createlisting

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.coroutines.runBlocking
import org.uwaterloo.subletr.api.apis.DefaultApi
import org.uwaterloo.subletr.api.models.CreateListingRequest
import org.uwaterloo.subletr.api.models.ListingsImagesCreateRequest
import org.uwaterloo.subletr.api.models.ResidenceType
import org.uwaterloo.subletr.enums.HousingType
import org.uwaterloo.subletr.services.INavigationService
import javax.inject.Inject

@HiltViewModel
class CreateListingPageViewModel @Inject constructor(
	private val api: DefaultApi,
	val navigationService: INavigationService,
) : ViewModel() {
	private val disposables: MutableList<Disposable> = mutableListOf()

	val navHostController get() = navigationService.getNavHostController()

	val addressLineStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")
	val addressCityStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")
	val addressPostalCodeStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")

	val descriptionStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")
	val priceStream: BehaviorSubject<Int> = BehaviorSubject.createDefault(0)
	val numBedroomsStream: BehaviorSubject<Int> = BehaviorSubject.createDefault(0)
	val startDateStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")
	val endDateStream: BehaviorSubject<String> = BehaviorSubject.createDefault("")

	val imagesByteStream: BehaviorSubject<MutableList<String>> = BehaviorSubject.createDefault(ArrayList())

	val uiStateStream: Observable<CreateListingPageUiState> = Observable.combineLatest(
		addressLineStream,
		addressCityStream,
		addressPostalCodeStream,
		descriptionStream,
		priceStream,
		numBedroomsStream,
		startDateStream,
		endDateStream,
		imagesByteStream
	) {
			addressLine, addressCity, addressPostalCode, description, price, numBedrooms, startDate, endDate, images ->
		CreateListingPageUiState.Loaded(
			addressLine = addressLine,
			addressCity = addressCity,
			addressPostalCode = addressPostalCode,
			addressCountry = "Canada",
			description = description,
			price = price,
			numBedrooms = numBedrooms,
			startDate = startDate,
			endDate = endDate,
			housingType = HousingType.OTHER,
			images = images,
		)
	}

	val createListingStream: PublishSubject<CreateListingPageUiState.Loaded> = PublishSubject.create()

	init {
		disposables.add(
			createListingStream.map {
				runBlocking {
					val imgId = api.listingsImagesCreate(
						ListingsImagesCreateRequest(
							image = it.images[0]
						)
					).imageId
					api.listingsCreate(
						CreateListingRequest(
							addressLine = it.addressLine,
							addressCity = it.addressCity,
							addressPostalcode = it.addressPostalCode,
							addressCountry = it.addressCountry,
							price = it.price,
							rooms = it.numBedrooms,
							leaseStart = it.startDate,
							leaseEnd = it.endDate,
							description = it.description,
							residenceType = ResidenceType.house,
							imgIds = listOf(imgId)
						)
					)
				}
			}
				.map {
					navHostController.popBackStack()
				}
				.doOnError {
					Log.d("API ERROR", "Create listing failed	")
				}
				.subscribeOn(Schedulers.io())
				.onErrorResumeWith(Observable.never())
				.subscribe()
		)
	}
	override fun onCleared() {
		super.onCleared()
		disposables.forEach {
			it.dispose()
		}
	}

}
