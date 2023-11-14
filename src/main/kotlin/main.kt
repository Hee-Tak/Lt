fun main() {
    val lotto = Lotto()
    val sheet: MutableList<MutableList<Int>> = mutableListOf()
    while(true){
        println()
        println("========================================================")
        println(" [1:로또구매\t2:보유중인Sheets확인\t3:당첨번호확인\t4:종료]")
        println("========================================================")
        print("=> ")
        val choose = readLine().toString().trim().toInt()
        when(choose){
            1 -> {
                print("필요한 매수를 입력하세요. => ")
                val num = readLine().toString().trim()
                try{
                    val n = num.toInt()
                    println("${n}장 출력됩니다.")
                    for(i in 1..n){
                        sheet.add(oneSheet())
                    }
                } catch(e: NumberFormatException){
                    println("잘못된 입력으로 한장만 출력됩니다.")
                    sheet.add(oneSheet())
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
                val result = lotto.prizeNumber().first
                println("\t\t<당첨번호>")
                lotto.printLotto(result)

                println("\t\t<결과>")
                checkLotto(sheet, result)
            }
            4 -> {
                return
            }
            else -> {
                println("올바른 형식으로 입력하세요.")
            }

        }
    }

}

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

public fun checkLotto(sheet: MutableList<MutableList<Int>>, result: MutableList<Int>) {
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
        println("\t\t${count}개 일치")
    }
}

