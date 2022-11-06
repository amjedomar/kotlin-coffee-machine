package machine

class CoffeeMachine(
    private var water: Int,
    private var milk: Int,
    private var coffeeBeans: Int,
    private var disposableCups: Int,
    private var money: Int
) {
    private fun printMachineState() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffeeBeans g of coffee beans")
        println("$disposableCups disposable cups")
        println("$$money of money")
    }

    private fun printFillPrompt() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()

        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()

        println("Write how many grams of coffee beans you want to add:")
        coffeeBeans += readln().toInt()

        println("Write how many disposable cups you want to add:")
        disposableCups += readln().toInt()
    }

    private fun makeCoffee(
        iWater: Int,
        iCoffeeBeans: Int,
        iMilk: Int,
        cost: Int,
    ) {
        if (water < iWater) {
            println("Sorry, not enough water!")
            return
        } else if (coffeeBeans < iCoffeeBeans) {
            println("Sorry, not enough coffee beans!")
            return
        } else if (milk < iMilk) {
            println("Sorry, not enough milk!")
            return
        }

        println("I have enough resources, making you a coffee!")

        water -= iWater
        coffeeBeans -= iCoffeeBeans
        milk -= iMilk
        disposableCups--
        money += cost
    }

    private fun printBuyPrompt() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")

        val input = readln()

        if (input == "back") {
            return
        }

        when (input.toInt()) {
            1 -> makeCoffee(250, 16, 0, 4)
            2 -> makeCoffee(350, 20, 75, 7)
            3 -> makeCoffee(200, 12, 100, 6)
        }
    }

    private fun printMoney() {
        println("I gave you $$money")
        money = 0
    }

    fun runMachine() {
        println("Write action (buy, fill, take, remaining, exit):")

        val action = readln()

        println()

        var isExit = false

        when (action) {
            "buy" -> printBuyPrompt()
            "fill" -> printFillPrompt()
            "take" -> printMoney()
            "remaining" -> printMachineState()
            "exit" -> isExit = true
        }

        if (!isExit) {
            println()
            runMachine()
        }
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine(
        water = 400,
        milk = 540,
        coffeeBeans = 120,
        disposableCups = 9,
        money = 550
    );

    coffeeMachine.runMachine()
}
