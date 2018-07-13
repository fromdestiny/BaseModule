package petaz.co.kr.sallim9dan.data.network.error

interface ErrorResponse {
    fun errorCode(): Int
    fun errorMessage(): String
    fun kind(): ErrorKind
}