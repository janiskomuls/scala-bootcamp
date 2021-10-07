package com.evolution.casino.updater

import com.evolution.casino.CasinoService
import com.evolution.casino.domain.Casino

class CasinoHttpClient(
    service: CasinoService,
    http: HttpClient,
    conf: HttpConfig,
    jsonParser: JsonParser
) {
  def retrieveCasinos: List[Casino] = {
    val response = http.post(Request(service.lastUpdated.toString, conf.url))
    val casinos = jsonParser.parseList(response.body)
    Utils.log(s"retrieved casinos: $casinos")
    casinos
  }
}
