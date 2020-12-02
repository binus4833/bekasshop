<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
    include_once("config.php");
       
    $emails = $_POST['emails'];
	$username = $_POST['username'];
 	$password = $_POST['password'];
  
	if($emails == '' || $username == '' || $password == ''){
	    echo json_encode(array( "status" => "false","message" => "Parameter missing!") );
	}else{	 
	    $query= "SELECT * FROM users WHERE emails='$emails'";
		$result= mysqli_query($con, $query);
		
		$queryUser= "SELECT * FROM users WHERE emails='$emails'";
		$resultUser= mysqli_query($con, $queryUser);
		
	    if(mysqli_num_rows($result) > 0){  
			echo json_encode(array( "status" => "false","message" => "Email already exist!") );
		}
	    else if(mysqli_num_rows($resultUser) > 0){  
	        echo json_encode(array( "status" => "false","message" => "User already exist!") );
	    }else{ 
		 	$query = "INSERT INTO users (emails,username,password) VALUES ('$emails','$username','$password')";
			if(mysqli_query($con,$query)){
			    $query= "SELECT * FROM users WHERE username='$username'";
	            $result= mysqli_query($con, $query);
		        $emparray = array();
	            if(mysqli_num_rows($result) > 0){  
	                while ($row = mysqli_fetch_assoc($result)) {
                        $emparray[] = $row;
                    }
	            }
			    echo json_encode(array( "status" => "true","message" => "Successfully registered!" , "data" => $emparray) );
		 	}else{
		 		echo json_encode(array( "status" => "false","message" => "Error occured, please try again!") );
		 	}
	    }
	    mysqli_close($con);
	 }
}
else{
    echo json_encode(array( "status" => "false","message" => "Error occured, please try again!") );
}
 
 ?>