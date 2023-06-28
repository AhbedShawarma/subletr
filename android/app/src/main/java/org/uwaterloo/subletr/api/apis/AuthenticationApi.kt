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

import org.uwaterloo.subletr.api.models.UserLoginRequest
import org.uwaterloo.subletr.api.models.UserLoginResponse

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

class AuthenticationApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "/api")
        }
    }

    /**
     * 
     * 
     * @param userLoginRequest 
     * @return UserLoginResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    suspend fun authLogin(userLoginRequest: UserLoginRequest) : UserLoginResponse = withContext(Dispatchers.IO) {
        val localVarResponse = authLoginWithHttpInfo(userLoginRequest = userLoginRequest)

        return@withContext when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as UserLoginResponse
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
     * @param userLoginRequest 
     * @return ApiResponse<UserLoginResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    suspend fun authLoginWithHttpInfo(userLoginRequest: UserLoginRequest) : ApiResponse<UserLoginResponse?> = withContext(Dispatchers.IO) {
        val localVariableConfig = authLoginRequestConfig(userLoginRequest = userLoginRequest)

        return@withContext request<UserLoginRequest, UserLoginResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation authLogin
     *
     * @param userLoginRequest 
     * @return RequestConfig
     */
    fun authLoginRequestConfig(userLoginRequest: UserLoginRequest) : RequestConfig<UserLoginRequest> {
        val localVariableBody = userLoginRequest
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/auth/login",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}