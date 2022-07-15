package com.mistersomov.core_data.mapper

import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.core_data.network.model.crypto.CoinInfoDto
import com.mistersomov.core_data.network.model.crypto.CoinInfoJsonContainerDto
import com.mistersomov.core_data.network.model.crypto.CoinListDto

interface ICoinMapper {

    fun mapDtoToCoinInfoDbModel(dto: CoinInfoDto): CoinInfoDbModel

    fun mapJsonToListCoinInfo(coinInfoJsonContainerDto: CoinInfoJsonContainerDto): List<CoinInfoDto>

    fun mapCoinListDtoToString(coinListDto: CoinListDto): String

}