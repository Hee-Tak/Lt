import java.util.*

class Lotto {
    //================================================================================================
    public fun AutoLotto(): List<Int> {     //자동으로 6개 랜덤 뽑기
        val lottoNumbers = mutableListOf<Int>()
        val random = Random()

        while(lottoNumbers.size < 6){
            val randomNumber = random.nextInt(45) + 1

            if(!lottoNumbers.contains(randomNumber)){
                lottoNumbers.add(randomNumber)
            }

        }
        val lotto = lottoNumbers.sorted()
        return lotto
    }
    //뻔한 숫자조합 피하는 알고리즘 추가? < 좀 애매

    //================================================================================================

    public fun manualLotto(): MutableList<Int> {       //수동으로 6개 뽑기
        var lottoNumbers = mutableListOf<Int>()

        println("<수동 6개>")
        println("1: 한번에 입력 // 2: 하나씩 입력 // 3: 섞어서 자유롭게 ")
        val input = readLine()!!.toInt()
        when(input){
            1 -> {
                lottoNumbers = oneLineInput()
            }
            2 -> {
                lottoNumbers = eachEnterInput()
            }
            3 -> {
                lottoNumbers = inputTest()
            }
        }
        return lottoNumbers
    }

    public fun oneLineInput(): MutableList<Int> {
        var lottoNumbers = mutableListOf<Int>()
        val input: String = readLine().toString()
        val arr = input.split(" ")
        lottoNumbers = arr.map { it.toInt() }.toMutableList()
        lottoNumbers.sort()
        return lottoNumbers
    }

    public fun eachEnterInput() : MutableList<Int> {
        val lottoNumbers = mutableListOf<Int>()

        while(lottoNumbers.size < 6){
            print("1~45의 숫자 6개 입력 : ")
            val input = readLine()
            try{
                val number = input?.toInt()
                if(number != null && number in 1..45 && number !in lottoNumbers){
                    lottoNumbers.add(number)
                } else {
                    println("유효한 숫자를 입력하세요.")
                }
            } catch(e: NumberFormatException){
                println("유효한 숫자를 입력하세요.")
            }
        }



        return lottoNumbers
    }

    public fun inputTest() : MutableList<Int> {
        /*
        val numbers = mutableListOf<Int>()
        println("1~45 6개의 숫자를 입력하세요. 여러 숫자를 공백으로 구분하거나 각 줄마다 하나의 숫자씩 입력할 수 있습니다. 입력을 완료하려면 빈 줄에서 엔터를 누르세요:")
        val inputLines = generateSequence { readLine() }.takeWhile { it.isNotEmpty() }
        val concatenatedIntput = inputLines.joinToString(" ")
        val inputNumbers = concatenatedIntput.trim().split("\\s+".toRegex()).map { it.toInt() }
        numbers.addAll(inputNumbers)
        val num = numbers.sorted()
        return num
        */
        val numbers = mutableListOf<Int>()

        println("숫자를 입력하세요. (1부터 45 사이의 숫자를 6개까지 입력할 수 있습니다)")

        while (numbers.size < 6) {
            val input = readLine()
            val inputNumbers = input?.trim()?.split("\\s+".toRegex())?.mapNotNull { it.toIntOrNull() }

            if (inputNumbers != null) {
                for (number in inputNumbers) {
                    if (number in 1..45 && numbers.size < 6) {
                        numbers.add(number)
                    } else {
                        println("1부터 45 사이의 유효한 숫자를 입력하세요.")
                    }
                }
            } else {
                println("유효한 숫자를 입력하세요.")
            }
        }
        val num = numbers.sorted()
        return num
    }


    //================================================================================================
    public fun prizeNumber(): List<Int> {   //당첨번호 6개 + 보너스 1개
        val lottoNumbers = mutableListOf<Int>()
        val random = Random()
        while(lottoNumbers.size < 6){
            val randomNumber = random.nextInt(45) + 1

            if(!lottoNumbers.contains(randomNumber)){
                lottoNumbers.add(randomNumber)
            }
        }


        while(lottoNumbers.size < 7){
            val bonus = random.nextInt(45) + 1

            if(!lottoNumbers.contains(bonus)){
                lottoNumbers.add(bonus)
            }
        }

        return lottoNumbers
    }

    //================================================================================================

    /*public fun halfAuto(): List<Int>{
        val lottoNumbers = mutableListOf<Int>()

    }*/
    //================================================================================================

    public fun printLotto(lotto: List<Int>) {
        for(element in lotto){
            print("${element}  ")
        }
        println()
    }
}