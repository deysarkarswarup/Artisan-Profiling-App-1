<?php
 $con=new mysqli("localhost","root","","artisan-profiling");


			
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$file_name = $_FILES['myFile']['name'];

		$file_size = $_FILES['myFile']['size'];
		$file_type = $_FILES['myFile']['type'];
		$temp_name = $_FILES['myFile']['tmp_name'];
				//$phno=$_POST['phoneno='];
		$location = "intro/";
		
		//$str="9433040463_intro.mp4";
		$id = preg_split("/\_/",$file_name);
		//echo $phn[0];
		
		move_uploaded_file($temp_name, $location.$file_name);

		$loc = $location.$file_name;
		//$nm = $_GET["name"];
		$st=$con->prepare("UPDATE `artisan` SET `artisanVideoUrl`=? WHERE `id`=?");
		$st->bind_param("ss", $loc, $id[0]);
		$st->execute();
		echo "data uploaded successfully!";


	}else{
		echo "Error";
	}

	?>