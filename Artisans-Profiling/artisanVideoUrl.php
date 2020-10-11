<?php
 // $con=new mysqli("localhost","root","","artisan-profiling");
$con= mysqli_connect("localhost","root","","artisan-profiling");
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$file = $_FILES['myFile']['name'];
		// $file_size = $_FILES['myFile']['size'];
		// $file_type = $_FILES['myFile']['type'];
		$temp_name = $_FILES['myFile']['tmp_name'];
				//$phno=$_POST['phoneno='];
		$location = "intro/";
		// echo $temp_name;
	//	etar output ta ekbar boltoh hmm
		//$str="9433040463_intro.mp4";
		$id = preg_split("/\*/",$file);
		//echo $phn[0]
		$file_name = $id[0];
		move_uploaded_file($temp_name, $location.$file_name);
		$loc = $location.$file_name;
		//$nm = $_GET["name"];
		// $st=$con->prepare("UPDATE `artisan` SET `artisanVideoUrl`=? WHERE `id`=?");
		// $st->bind_param("ss", $loc, $id[0]);
		// $st->execute(); hoyechilo ota?haaa
		// echo $file_name;
		// echo $loc;
		$i = $id[1];
		$query = "UPDATE `artisan` SET `artisanVideoUrl`='$loc' WHERE `id`='$i'";
		$result = mysqli_query($con,$query);
		echo "data uploaded successfully!";
	}else{
		echo "Error";
	}
//issues run kora, file name ta dekhhmmmm eitai dekhache filename e
//volley timeout error in experience.php
//video not previewing in new phone
//need to update php files for insert statement 
	?>

