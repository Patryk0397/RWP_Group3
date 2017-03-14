<?php
    
	$con = mysqli_connect("localhost", "root", "", "gompare");
    
 
    $username = $_POST["username"];
    $password = $_POST["password"];
	
	
    $statement = mysqli_prepare($con, "INSERT INTO user (username, password) VALUES (?,?)");
    mysqli_stmt_bind_param($statement, "siss", $username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>