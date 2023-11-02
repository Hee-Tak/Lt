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

        return lottoNumbers
    }
    //뻔한 숫자조합 피하는 알고리즘 추가? < 좀 애매

    //================================================================================================

    public fun manualLotto(): List<Int> {       //수동으로 6개 뽑기
        val lottoNumbers = mutableListOf<Int>()

        while(lottoNumbers.size < 6){
            print("1~45의 숫자 6개 입력 (종료 : exit) : ")
            val input = readLine()
            if(input == "exit") break
            else {
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

        }

        return lottoNumbers
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
}