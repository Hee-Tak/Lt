fun main() {
    val lotto = Lotto()


    var user : MutableList<Int>
    println("1:자동 \t 2:수동 \t 3:반자동")
    print("=> ")
2
    var choose = readLine().toString().toInt()
    while(choose in 1..3){
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
                //반자동만들기
                break
            }

            else -> {
                choose = (1..3).random()
            }

        }
    }


    val result = lotto.prizeNumber()


}