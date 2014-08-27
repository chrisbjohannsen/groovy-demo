def foo(str) {

	//traditional style
	//if(str != null) { str.reverse() } 
		
	//groovy way
	str?.reverse()
}

println foo("evil")
println foo(null)