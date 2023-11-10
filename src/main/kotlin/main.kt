fun main() {
    val lotto = Lotto()
    val sheet: MutableList<MutableList<Int>> = mutableListOf()
    while(true){
        println("1:로또구매\t2:보유중인Sheets확인\t3:당첨번호확인")
        print("=> ")
        val choose = readLine().toString().trim().toInt()
        when(choose){
            1 -> {
                sheet.add(oneSheet())
            }
            2 -> {
                printSheets(sheet)
            }
            3 -> {
                break
            }
            else -> {
                println("올바른 형식으로 입력하세요.")
            }

        }
    }
    val result = lotto.prizeNumber()

}

public fun oneSheet() : MutableList<Int> {
    val lotto = Lotto()
    var user : MutableList<Int> = mutableListOf()
    var choose : Int


    while(true){
        println("1:자동 \t 2:수동 \t 3:반자동")
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
    for(list in sheet){
        var count = 1
        for(element in list){
            print("${count++}번 )")
            print("$element ")
        }
        println()
    }
}