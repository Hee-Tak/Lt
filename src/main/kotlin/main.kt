import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

fun main() {

    oneSet().oneSet()   //oneSet 클래스의 oneSet 함수 호출(원래는 생성자 불러내는 느낌으로 하려고 했는데..)
                        //원래는 val start = oneSet().oneSet() 이였는데, 이게 반환값이 결국에 void 다 보니까 (없다보니까) 그냥 이렇게해도 됨
                        //사실 자꾸 회색글씨로 표시되길래 알아차림

}




fun JDBC_TEST() {
    //JDBC 연결 정보
    val jdbcURL = "jdbc:mysql://localhost:3306/mysql"
    val user = "your_username"
    val password ="your_password"

    //JDBC 드라이버 로드
    Class.forName("com.mysql.cj.jdbc.Driver")

    //데이터베이스 연결
    val connection: Connection = DriverManager.getConnection(jdbcURL, user, password)

    //데이터베이스에 데이터 추가
    insertData(connection, 100000)

    //데이터베이스에서 데이터 조회
    queryData(connection)

    //연결 닫기
    connection.close()
}

fun insertData(connection: Connection, money: Int) {
    val insertQuery = "INSERT INTO Lotto (money) VALUES (?)"

    //PreparedStatement 사용하여 SQL 쿼리 실행
    val preparedStatement: PreparedStatement = connection.prepareStatement(insertQuery)
    preparedStatement.setInt(1, money)
    preparedStatement.executeUpdate()

    println("Data inserted successfully.")
}

fun queryData(connection: Connection) {
    val selectQuery = "SELECT * FROM Lotto"

    //PreparedStatement 사용하여 SQL 쿼리 실행
    val preparedStatement: PreparedStatement = connection.prepareStatement(selectQuery)
    val resultSet : ResultSet = preparedStatement.executeQuery()

    //결과 출력
    while(resultSet.next()){
        val id = resultSet.getInt("id")
        val money = resultSet.getInt("money")

        println("ID: $id, Money: $money")
    }

    resultSet.close()
    preparedStatement.close()
}