package demidova.alcodb.imgConverter

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ErrorView {
    fun showErrorBar()

    fun hideErrorBar()

}
