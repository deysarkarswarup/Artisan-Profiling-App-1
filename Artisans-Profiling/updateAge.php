<?php
		$con=mysqli_connect("localhost","root","","artisan-profiling");

		
		$a =$_GET["id"];
		$p = $_GET["age"];

		$st=$con->prepare("UPDATE `extras` SET `age`=? WHERE `artisanid`=?");
		$st->bind_param("ss", $p, $a);
		$st->execute();

		echo "data uploaded successfully!";
?>
