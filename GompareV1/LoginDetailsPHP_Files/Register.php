<?php
    
	$con = mysqli_connect("gompare.000webhostapp.com", "id985205_gompare", "gompare101", "id985205_users");
    
 
    $username = $_POST["username"];
    $password = $_POST["password"];
	
	
    $statement = mysqli_prepare($con, "INSERT INTO user (username, password) VALUES (?,?)");
    mysqli_stmt_bind_param($statement, "siss", $username, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>