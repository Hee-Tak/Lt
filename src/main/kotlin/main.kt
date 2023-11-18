fun main() {



}





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
            println("\t\t\t1등")
        } else if(count == 5){
            if(bonus in list){
                println("\t\t\t2등")
            } else {
                println("\t\t\t3등")
            }
        } else if(count == 4){
            println("\t\t\t4등")
        } else if(count == 3){
            println("\t\t\t5등")
        } else {
            println("\t\t\t꽝")
        }

    }
}




//1등 : 6개 번호 모두 일치 (당첨확률 : 1 / 8,145,060 || 조합 개수 1) (기대 당첨금 1,952,160,000) (총 당첨금 중 4등과 5등 금액을 제외한 금액의 75%)
//2등 : 5개 번호 일치 + 나머지 1개가 2등 보너스볼 번호 일치 (당첨확률 : 1 / 1,357,510 || 조합 개수 6) (기대 당첨금 54,226,666) (총 당첨금 중 4등과 5등 금액을 제외한 금액의 12.5%)
//3등 : 5개 번호 일치 (당첨확률 : 1 / 35,724 || 조합 개수 228) (기대 당첨금 1,427,017) (총 당첨금 중 4등과 5등 금액을 제외한 금액의 12.5%)
//4등 : 4개 번호 일치 (당첨확률 : 1 / 733 || 조합 개수 11,115) (5만원)
//5등 : 3개 번호 일치 (당첨확률 : 1 / 45 || 조합 개수 182,780) (5천원)