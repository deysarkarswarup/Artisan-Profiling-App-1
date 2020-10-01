<?php
$con= mysqli_connect("localhost","root","","artisan-profiling");
			
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$file = $_FILES['myFile']['name'];

		//$file_size = $_FILES['myFile']['size'];
		//$file_type = $_FILES['myFile']['type'];
		$temp_name = $_FILES['myFile']['tmp_name'];
				//$phno=$_POST['phoneno='];
		$location = "artwork/";
		
		//$str="9433040463_intro.mp4";
		//$id = preg_split("/\_/",$file_name);
		//echo $phn[0];
		$id = preg_split("/\*/",$file);
		//echo $phn[0]
		$file_name = $id[0];
		move_uploaded_file($temp_name, $location.$file_name);

		$loc = $location.$file_name;
		//$nm = $_GET["name"];
		//$st=$con->prepare("UPDATE `artisan` SET `productDescriptionVideoUrl`=? WHERE `id`=?");
		//$st->bind_param("ss", $loc, $id[0]);
		//$st->execute();
		//echo "data uploaded successfully!";

		$i = $id[1];
		$query = "UPDATE `artisan` SET `productDescriptionVideoUrl`='$loc' WHERE `id`='$i'";
		$result = mysqli_query($con,$query);
		echo "data uploaded successfully!";


	}else{
		echo "Error";
	}

	?>