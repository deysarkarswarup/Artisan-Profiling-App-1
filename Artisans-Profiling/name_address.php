<?php
//$con=new mysqli("localhost","id14527893_root","grB8e0[@rJ[\OOi=","id14527893_artisansprofiling");
		$con=new mysqli("localhost","root","","artisan-profiling");

		$name = $_GET["name"];
		$b = $_GET["district"];
		$c =$_GET["addressLine1"];
		$d = $_GET["addressLine2"];
		$e =$_GET["pinCode"];
		$f = $_GET["landMark"];
		$a =$_GET["id"];
		$x =$_GET["addressExp"];
		$age =$_GET["age"];

		$st=$con->prepare("UPDATE `artisan` SET `name`=?, `district`=?, `addressLine1`=?, `addressLine2`=?, `pinCode`=?, `landMark`=? WHERE `id`=?");
		$st->bind_param("sssssss", $name, $b, $c, $d, $e, $f, $a);
		$st->execute();

		$st1=$con->prepare("INSERT INTO `extras` (`age`, `addressexp`,`artisanid`) VALUES (?,?,?)");
		$st1->bind_param("sss", $age, $x, $a);
		$st1->execute();

		echo "data uploaded successfully!";
		?>