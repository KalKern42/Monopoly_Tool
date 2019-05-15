## Monopoly Assist

## Overview

This is a program dessigned to aid in the playing of the monopoly boardgame by keeping track of player money, properties, and the properties' properties.

## Why does this exist?

Monopoly is a painful game to play, so we aim with this tool to make things a lot less painful by doing all the heavy lifting for you. With this too you can actually enjoy Monopoly.

## How to run

All the files are needed to run the program (excluding the README), but you will only be runing the Main.java file. 
[an example of the code running](Example_Of_Code.png)
 
## Code Examples

This is just a bit of code for the commandline. It is used to seperate the command from the targets using arrays
```
for (int c = 0; c < commBit.length; c++){
	storage = commBit[c]; //for easy comparing
	
	if (storage.contains(atCommand)) {
		commTarg[c] = "";
	}else {
		commTarg[c] = commBit[c];
	}
	//the command targets are stored and returns but the command is not
}

```

## The AMAZING people who made this possible
David Cosby
Justin Garnica
Kal Kern