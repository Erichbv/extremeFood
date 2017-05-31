<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
      try{
        $this->db = DB_Connect::connect();
      }catch(Exception $e)
        {
            die($e->getMessage());
        }
        
        
    }

    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($name,$lastname,$sex,$email, $password,$birthdate) {
        $now_date=date("d/m/Y");
        $uuid = uniqid('', true);
        $hash = $this->hashSSHA($password);
        $encrypted_password = $hash["encrypted"]; // encrypted password
        $salt = $hash["salt"]; // salt
        try{
        $sql="INSERT INTO users (unique_id, name, lastname, sex, email, encrypted_password, salt, birthdate, created_at) 
                VALUES (?,?,?,?,?,?,?,?,?) ";
        $result=$this->db->prepare($sql)
                ->execute(
                    array(
                        $uuid,
                        $name,
                        $lastname,
                        $sex,
                        $email,
                        $encrypted_password,
                        $salt,
                        $birthdate,
                        $now_date
                        )
                    );
     
        } catch (Exception $e) {
            die($e->getMessage());
        }

        try 
        {
    $stm = $this->db->prepare("SELECT * FROM users WHERE email = ?");
                    $stm->execute(array($email));
            // return user details
        return $stm->fetch(PDO::FETCH_OBJ);
                } catch (Exception $e) 
        {
            die($e->getMessage());
        }
    }

    /**
     * Get user by email and password
     */
    public function getUserByEmailAndPassword($email, $password) {
    try{
            $stm = $this->db->prepare("SELECT * FROM users WHERE email = ?");
                    $stm->execute(array($email));
            
            $result = $stm->fetch(PDO::FETCH_OBJ);
            if($result){
                $salt = $result->salt;
                $encrypted_password = $result->encrypted_password;
                $hash = $this->checkhashSSHA($salt,$password);
                if(strcmp($encrypted_password,$hash)==0){
                    return $result;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        
        
    } catch (Exception $e){
        die($e->getMessage());
    }
        
    }

    /**
     * Check user is existed or not
     */
    public function isUserExisted($email) {
        $stm = $this->db->prepare("SELECT email FROM users WHERE email=?");
            $stm->execute(array($email));
        $user=$stm->fetch(PDO::FETCH_OBJ);
        if($user!=null){
            return true;
        }else{
            false;
        }
    }

    /**
     * Encrypting password
     * @param password
     * returns salt and encrypted password
     */
    public function hashSSHA($password) {

        $salt = sha1(rand());
        $salt = substr($salt, 0, 10);
        $encrypted = base64_encode(sha1($password . $salt, true) . $salt);
        $hash = array("salt" => $salt, "encrypted" => $encrypted);
        return $hash;
    }

    /**
     * Decrypting password
     * @param salt, password
     * returns hash string
     */
    public function checkhashSSHA($salt, $password) {

        $hash = base64_encode(sha1($password . $salt, true) . $salt);

        return $hash;
    }

}

?>
