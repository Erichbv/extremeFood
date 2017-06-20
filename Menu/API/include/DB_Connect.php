<?php
class DB_Connect {

    // Connecting to database
    public static function connect() {
        // connecting to mysql
        $pdo = new PDO('mysql:host=localhost;dbname=extremefood_db;charset=utf8', 'root', '');
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);  
        return $pdo;
    }

    // Closing database connection
    public function close() {
        mysql_close();
    }

}

?>
