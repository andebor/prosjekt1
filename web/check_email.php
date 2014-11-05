<?php

include 'dbconn.php';

//check we have username post var
if(isset($_POST["email_input"]))
{    
    //trim and lowercase username
    $email_input =  strtolower(trim($_POST["email_input"])); 
    
    //sanitize username
    $email_input = filter_var($email_input, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_LOW|FILTER_FLAG_STRIP_HIGH);
    
    //check username in db
    $results = $mysqli->query("SELECT tenant_email FROM reservations WHERE tenant_email='$email_input'");
    
    //return total count
    $username_exist = mysqli_num_rows($results); //total records
    
    //if value is more than 0, username is not available
    if($username_exist) {
        echo '<p class="bg-success">Det finnes reservasjoner på denne eposten.</p>';
    }else{
        echo '<p class="bg-danger">Det finnes ingen reservasjon på denne eposten.</p>';
    }
}

?>