package de.samir.ramic.kmm.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


typealias AED = CurrencyDto
typealias ARS = CurrencyDto
typealias AUD = CurrencyDto
typealias BAM = CurrencyDto
typealias USD = CurrencyDto
typealias USDC = CurrencyDto
typealias USDT = CurrencyDto
typealias XAU = CurrencyDto
typealias ZAR = CurrencyDto
typealias BRL = CurrencyDto
typealias BTC = CurrencyDto
typealias CAD = CurrencyDto
typealias CHF = CurrencyDto
typealias CNY = CurrencyDto
typealias DKK = CurrencyDto
typealias ETH = CurrencyDto
typealias EUR = CurrencyDto
typealias GBP = CurrencyDto
typealias HKD = CurrencyDto
typealias IDR = CurrencyDto
typealias INR = CurrencyDto
typealias JPY = CurrencyDto
typealias KRW = CurrencyDto
typealias MXN = CurrencyDto
typealias NOK = CurrencyDto
typealias PLN = CurrencyDto
typealias RUB = CurrencyDto
typealias SEK = CurrencyDto
typealias THB = CurrencyDto
typealias TRY = CurrencyDto


@Serializable
data class CurrencyData(
    @SerialName("BAM") val bam: BAM,     // Bosnian Convertible Marka
    @SerialName("USD") val usd: USD,     // US Dollar
    @SerialName("EUR") val eur: EUR,     // Euro
    @SerialName("BTC") val btc: BTC,     // Bitcoin
    @SerialName("ETH") val eth: ETH,     // Ethereum
    @SerialName("USDT") val usdt: USDT,  // Tether (Stablecoin)
    @SerialName("USDC") val usdc: USDC,  // USD Coin (Stablecoin)
    @SerialName("GBP") val gbp: GBP,     // British Pound Sterling
    @SerialName("CHF") val chf: CHF,     // Swiss Franc
    @SerialName("JPY") val jpy: JPY,     // Japanese Yen
    @SerialName("AUD") val aud: AUD,     // Australian Dollar
    @SerialName("CAD") val cad: CAD,     // Canadian Dollar
    @SerialName("CNY") val cny: CNY,     // Chinese Yuan
    @SerialName("HKD") val hkd: HKD,     // Hong Kong Dollar
    @SerialName("INR") val inr: INR,     // Indian Rupee
    @SerialName("RUB") val rub: RUB,     // Russian Ruble
    @SerialName("BRL") val brl: BRL,     // Brazilian Real
    @SerialName("MXN") val mxn: MXN,     // Mexican Peso
    @SerialName("KRW") val krw: KRW,     // South Korean Won
    @SerialName("TRY") val try_: TRY,    // Turkish Lira
    @SerialName("PLN") val pln: PLN,     // Polish Złoty
    @SerialName("SEK") val sek: SEK,     // Swedish Krona
    @SerialName("NOK") val nok: NOK,     // Norwegian Krone
    @SerialName("DKK") val dkk: DKK,     // Danish Krone
    @SerialName("AED") val aed: AED,     // UAE Dirham
    @SerialName("ZAR") val zar: ZAR,     // South African Rand
    @SerialName("ARS") val ars: ARS,     // Argentine Peso
    @SerialName("IDR") val idr: IDR,     // Indonesian Rupiah
    @SerialName("THB") val thb: THB,     // Thai Baht
    @SerialName("XAU") val xau: XAU      // Gold (oz)
) {
    val allCurrencies
        get() = listOf(
            bam, usd, eur, btc, eth, usdt, usdc, gbp, chf, jpy,
            aud, cad, cny, hkd, inr, rub, brl, mxn, krw, try_,
            pln, sek, nok, dkk, aed, zar, ars, idr, thb, xau
        )
}