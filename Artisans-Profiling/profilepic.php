<?php
if(isset($_POST["encoded_string"])){
 	
 	$id = $_POST["id"];
	$encoded_string = $_POST["encoded_string"];
	$image_name = $_POST["image_name"];
	
	$decoded_string = base64_decode($encoded_string);
	
	$path = 'profilepic/'.$image_name;
	
	$file = fopen($path, 'wb');
	
	$is_written = fwrite($file, $decoded_string);
	fclose($file);
	
	if($is_written > 0) {
		


		$query = "UPDATE `artisan` SET `profilePicture` ='".$image_name."' WHERE `id`='".$id."'" ;
		$conn = mysqli_connect('localhost', 'root', '','artisan-profiling');
		$result = mysqli_query($conn, $query) ;
		
		if($result){
			echo "data uploaded successfully!";
		}else{
			echo "failed";
		}
		
		mysqli_close($conn);
	}
 }
?>
