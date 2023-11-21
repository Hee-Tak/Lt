import java.text.NumberFormat
import java.util.Locale

class oneSet {
    var money: Int = 10000 //기본 1만원
    fun oneSet() {

        val lotto = Lotto()
        val sheet: MutableList<MutableList<Int>> = mutableListOf()
        while(true){
            printMoney()
            println("================================================================================================================")
            println(" [1:로또구매(장당 1.0)\t2:보유중인Sheets확인\t3:당첨번호확인\t4:종료\t5:무료충전\t6:로또자동n장(장당 1.0)]")
            println("================================================================================================================")
            print("=> ")
            val choose = readLine().toString().trim().toInt()
            when(choose){
                1 -> {
                    print("필요한 매수를 입력하세요. => ")
                    val num = readLine().toString().trim()
                    try{
                        val n = num.toInt()
                        if(n*1000 <= money) {
                            println("${n}장 출력됩니다.")
                            for (i in 1..n) {
                                sheet.add(oneSheet())
                                money -= 1000
                            }
                        } else {
                            val d = n*1000 - money
                            val temp = NumberFormat.getNumberInstance(Locale.US).format(d)
                            println("잔액이 부족합니다. 부족한 금액 : ${temp}")
                        }
                    } catch(e: NumberFormatException){
                        println("잘못된 입력입니다. 처음부터 다시 입력하세요.")
                    }
                }
                2 -> {
                    if(sheet.isNotEmpty()) {
                        printSheets(sheet)
                    } else {
                        println("비어있습니다.")
                    }
                }
                3 -> {
                    val result = lotto.prizeNumber()
                    println("\t\t<당첨번호>")
                    lotto.printLotto(result.first)

                    println("\t\t<결과>")
                    checkLotto(sheet, result)

                    sheet.clear() //이번회차 확인했으니 비우고 다음회차.
                }
                4 -> {
                    return
                }

                5 -> {
                    money += 5000
                }

                6 -> {
                    print("필요한 매수를 입력하세요. => ")
                    val num = readLine().toString().trim()
                    try{
                        val n = num.toInt()
                        if(n*1000 <= money) {
                            println("${n}장 출력됩니다.")
                            for (i in 1..n) {
                                sheet.add(lotto.AutoLotto())
                                money -= 1000
                            }
                        } else {
                            val d = n*1000 - money
                            val temp = NumberFormat.getNumberInstance(Locale.US).format(d)
                            println("잔액이 부족합니다. 부족한 금액 : ${temp}")
                        }
                    } catch(e: NumberFormatException){
                        println("잘못된 입력입니다. 처음부터 다시 입력하세요.")
                    }
                }
                else -> {
                    println("올바른 형식으로 입력하세요.")
                }

            }
        }

        printMoney()

    }

    //========================================================================
    public fun oneSheet() : MutableList<Int> {
        val lotto = Lotto()
        var user : MutableList<Int> = mutableListOf()
        var choose : Int

        while(true){
            println("[1:자동 \t 2:수동 \t 3:반자동]")
            print("=> ")
            val temp_choose = readLine().toString().trim()
            try {
                choose = temp_choose.toInt()
                break
            } catch (e: NumberFormatException) {
                println("올바른 형식으로 숫자 하나를 입력하세요. (1, 2, 3)")
            }
        }

        while(true){
            when(choose){
                1 -> {
                    println("<자동>")
                    user = lotto.AutoLotto() //자동
                    lotto.printLotto(user)
                    break
                }


                2 -> {
                    println("<수동>")
                    user = lotto.manualLotto() //수동
                    lotto.printLotto(user)
                    break
                }


                3 -> {
                    println("<반자동>")
                    user = lotto.halfAuto() //반자동
                    lotto.printLotto(user)
                    break
                }

                else -> {
                    choose = (1..3).random()
                }

            }
        }

        return user

    }
    //================================================================
    public fun printSheets(sheet: MutableList<MutableList<Int>>) {
        var count = 1
        for(list in sheet){
            print("${count++}번) ")
            for(element in list){
                print("$element ")
            }
            println()
        }
    }

    //====================================================================

    public fun checkLotto(sheet: MutableList<MutableList<Int>>, prize: Pair<MutableList<Int>, Int>) {
        val result = prize.first
        val bonus = prize.second

        var num = 1

        for(list in sheet){
            var count = 1
            print("${num++}번) ")
            for(element in list){
                print("$element ")
                if(element in result){
                    count++
                }
            }
            //println("\t\t${count}개 일치")
            if(count == 6){
                val prizeMoney =1952160000
                println("\t\t\t\t1등\t+${prizeMoney}")
                money += prizeMoney
            } else if(count == 5){
                if(bonus in list){
                    val prizeMoney = 54226666
                    println("\t\t\t\t2등\t+${prizeMoney}")
                    money += prizeMoney
                } else {
                    val prizeMoney = 1427017
                    println("\t\t\t\t3등\t+${prizeMoney}")
                    money += prizeMoney
                }
            } else if(count == 4){
                val prizeMoney = 50000
                println("\t\t\t\t4등\t+${prizeMoney}")
                money += prizeMoney
            } else if(count == 3){
                val prizeMoney = 5000
                println("\t\t\t\t5등\t+${prizeMoney}")
                money += prizeMoney
            } else {
                println("\t\t\t\t꽝")
            }

        }
    }

    //1등 : 6개 번호 모두 일치 (당첨확률 : 1 / 8,145,060 || 조합 개수 1) (기대 당첨금 1,952,160,000) (총 당첨금 중 4등과 5등 금액을 제외한 금액의 75%)
    //2등 : 5개 번호 일치 + 나머지 1개가 2등 보너스볼 번호 일치 (당첨확률 : 1 / 1,357,510 || 조합 개수 6) (기대 당첨금 54,226,666) (총 당첨금 중 4등과 5등 금액을 제외한 금액의 12.5%)
    //3등 : 5개 번호 일치 (당첨확률 : 1 / 35,724 || 조합 개수 228) (기대 당첨금 1,427,017) (총 당첨금 중 4등과 5등 금액을 제외한 금액의 12.5%)
    //4등 : 4개 번호 일치 (당첨확률 : 1 / 733 || 조합 개수 11,115) (5만원)
    //5등 : 3개 번호 일치 (당첨확률 : 1 / 45 || 조합 개수 182,780) (5천원)

    public fun printMoney(){
        val temp = NumberFormat.getNumberInstance(Locale.US).format(money)

        println("현재 지니고 있는 금액 : ${temp} 원")
    }


}