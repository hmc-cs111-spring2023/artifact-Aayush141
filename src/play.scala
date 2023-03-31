case class PhonemicString(strt: String):
	var xSampa = List(List("@","ə"),List("E","ɛ")) 
    // List(List("A", "ɑ"), List("a", "æ"), List("@", "ə"), List("E", "ɛ"), List("I", "ɪ"), List("i", "i"), List("O", "ɔ"), List("o", "o"), List("U", "ʊ"), List("u", "u"), List("3", "ɜ"), List("6", "ɐ"), List("7", "ɨ"), List("8", "ɵ"), List("9", "ɘ"), List("&", "æ"), List("@`", "ɚ"))
	def =~(newStr: PhonemicString) = (strt == newStr.strt)

given Conversion[String,PhonemicString] = n => PhonemicString(n)

//var d = "\hE:loU\"

var g = "he"

PhonemicString("he") =~ g