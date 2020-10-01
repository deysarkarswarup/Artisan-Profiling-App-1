<?php
		$con=mysqli_connect("localhost","root","","artisan-profiling");

		
		$a =$_GET["id"];
		$p = $_GET["phone"];

		$st=$con->prepare("UPDATE `artisan` SET `phone`=? WHERE `id`=?");
		$st->bind_param("ss", $p, $a);
		$st->execute();

		echo "data uploaded successfully!";
?>