/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.uwaterloo.subletr.api.apis

import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.HttpUrl

import org.uwaterloo.subletr.api.models.ChangePasswordUserRequest
import org.uwaterloo.subletr.api.models.CreateUserRequest
import org.uwaterloo.subletr.api.models.CreateUserResponse
import org.uwaterloo.subletr.api.models.GetUserResponse
import org.uwaterloo.subletr.api.models.RateUserRequest
import org.uwaterloo.subletr.api.models.UpdateUserRequest

import com.squareup.moshi.Json

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.uwaterloo.subletr.api.infrastructure.ApiClient
import org.uwaterloo.subletr.api.infrastructure.ApiResponse
import org.uwaterloo.subletr.api.infrastructure.ClientException
import org.uwaterloo.subletr.api.infrastructure.ClientError
import org.uwaterloo.subletr.api.infrastructure.ServerException
import org.uwaterloo.subletr.api.infrastructure.ServerError
import org.uwaterloo.subletr.api.infrastructure.MultiValueMap
import org.uwaterloo.subletr.api.infrastructure.PartConfig
import org.uwaterloo.subletr.api.infrastructure.RequestConfig
import org.uwaterloo.subletr.api.infrastructure.RequestMethod
import org.uwaterloo.subletr.api.infrastructure.ResponseType
import org.uwaterloo.subletr.api.infrastructure.Success
import org.uwaterloo.subletr.api.infrastructure.toMultiValue

class UserApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "/api")
        }
    }

    /**
     * 
     * 
     * @param changePasswordUserRequest 
     * @return kotlin.Any
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun userChangePassword(changePasswordUserRequest: ChangePasswordUserRequest) : kotlin.Any = withContext(Dispatchers.IO) {
        val localVarResponse = userChangePasswordWithHttpInfo(changePasswordUserRequest = changePasswordUserRequest)

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Any
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param changePasswordUserRequest 
     * @return ApiResponse<kotlin.Any?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun userChangePasswordWithHttpInfo(changePasswordUserRequest: ChangePasswordUserRequest) : ApiResponse<kotlin.Any?> = withContext(Dispatchers.IO) {
        val localVariableConfig = userChangePasswordRequestConfig(changePasswordUserRequest = changePasswordUserRequest)

        return@withContext request<ChangePasswordUserRequest, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation userChangePassword
     *
     * @param changePasswordUserRequest 
     * @return RequestConfig
     */
    fun userChangePasswordRequestConfig(changePasswordUserRequest: ChangePasswordUserRequest) : RequestConfig<ChangePasswordUserRequest> {
        val localVariableBody = changePasswordUserRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/user/change_password",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @param createUserRequest 
     * @return CreateUserResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun userCreate(createUserRequest: CreateUserRequest) : CreateUserResponse = withContext(Dispatchers.IO) {
        val localVarResponse = userCreateWithHttpInfo(createUserRequest = createUserRequest)

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as CreateUserResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param createUserRequest 
     * @return ApiResponse<CreateUserResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun userCreateWithHttpInfo(createUserRequest: CreateUserRequest) : ApiResponse<CreateUserResponse?> = withContext(Dispatchers.IO) {
        val localVariableConfig = userCreateRequestConfig(createUserRequest = createUserRequest)

        return@withContext request<CreateUserRequest, CreateUserResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation userCreate
     *
     * @param createUserRequest 
     * @return RequestConfig
     */
    fun userCreateRequestConfig(createUserRequest: CreateUserRequest) : RequestConfig<CreateUserRequest> {
        val localVariableBody = createUserRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/user/create",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @return GetUserResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun userGet() : GetUserResponse = withContext(Dispatchers.IO) {
        val localVarResponse = userGetWithHttpInfo()

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GetUserResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @return ApiResponse<GetUserResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun userGetWithHttpInfo() : ApiResponse<GetUserResponse?> = withContext(Dispatchers.IO) {
        val localVariableConfig = userGetRequestConfig()

        return@withContext request<Unit, GetUserResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation userGet
     *
     * @return RequestConfig
     */
    fun userGetRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/user/get",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @param userId 
     * @return kotlin.Float
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun userGetRating(userId: kotlin.Int) : kotlin.Float = withContext(Dispatchers.IO) {
        val localVarResponse = userGetRatingWithHttpInfo(userId = userId)

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Float
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param userId 
     * @return ApiResponse<kotlin.Float?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun userGetRatingWithHttpInfo(userId: kotlin.Int) : ApiResponse<kotlin.Float?> = withContext(Dispatchers.IO) {
        val localVariableConfig = userGetRatingRequestConfig(userId = userId)

        return@withContext request<Unit, kotlin.Float>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation userGetRating
     *
     * @param userId 
     * @return RequestConfig
     */
    fun userGetRatingRequestConfig(userId: kotlin.Int) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                put("user_id", listOf(userId.toString()))
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/user/get_rating",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @param rateUserRequest 
     * @return kotlin.String
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun userRate(rateUserRequest: RateUserRequest) : kotlin.String = withContext(Dispatchers.IO) {
        val localVarResponse = userRateWithHttpInfo(rateUserRequest = rateUserRequest)

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.String
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param rateUserRequest 
     * @return ApiResponse<kotlin.String?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun userRateWithHttpInfo(rateUserRequest: RateUserRequest) : ApiResponse<kotlin.String?> = withContext(Dispatchers.IO) {
        val localVariableConfig = userRateRequestConfig(rateUserRequest = rateUserRequest)

        return@withContext request<RateUserRequest, kotlin.String>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation userRate
     *
     * @param rateUserRequest 
     * @return RequestConfig
     */
    fun userRateRequestConfig(rateUserRequest: RateUserRequest) : RequestConfig<RateUserRequest> {
        val localVariableBody = rateUserRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/user/rate",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * 
     * 
     * @param updateUserRequest 
     * @return kotlin.Any
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun userUpdate(updateUserRequest: UpdateUserRequest) : kotlin.Any = withContext(Dispatchers.IO) {
        val localVarResponse = userUpdateWithHttpInfo(updateUserRequest = updateUserRequest)

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.Any
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * 
     * 
     * @param updateUserRequest 
     * @return ApiResponse<kotlin.Any?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun userUpdateWithHttpInfo(updateUserRequest: UpdateUserRequest) : ApiResponse<kotlin.Any?> = withContext(Dispatchers.IO) {
        val localVariableConfig = userUpdateRequestConfig(updateUserRequest = updateUserRequest)

        return@withContext request<UpdateUserRequest, kotlin.Any>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation userUpdate
     *
     * @param updateUserRequest 
     * @return RequestConfig
     */
    fun userUpdateRequestConfig(updateUserRequest: UpdateUserRequest) : RequestConfig<UpdateUserRequest> {
        val localVariableBody = updateUserRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/user/update",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
