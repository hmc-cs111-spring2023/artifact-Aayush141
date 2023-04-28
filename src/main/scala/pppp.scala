object pppp{

	// Unordered String 

	// A case class representing an unordered string

	case class unorderedString(strt: String) {

		var strArr = (strt.toCharArray()).sorted
		var strArrDist = strArr.distinct

		// Override the toString method to return the sorted string
		override def toString = strArr.mkString("")

		def ~~(newStr: unorderedString) = (strArr.sameElements(newStr.strArr))
		def ~~=(newStr: unorderedString) = (strArrDist.sameElements(newStr.strArrDist))

		def -(newStr: unorderedString) = (unorderedString(((strArr).diff(newStr.strArr)).mkString("")))

		def ⊆(newStr: unorderedString) = (strArrDist.diff(newStr.strArrDist).isEmpty)
		def ⊇(newStr: unorderedString) = ((newStr.strArrDist).diff(strArrDist).isEmpty)

		def ?(chars: Char) = strArr.groupBy(identity).mapValues(_.size)(chars)
		def frequencyOf(chars: Char) = strArr.groupBy(identity).mapValues(_.size)(chars)
	}


	// Implicit conversions between String and unorderedString
	given Conversion[String,unorderedString] = n => unorderedString(n)
	given Conversion[unorderedString, String] = n => n.toString

	// Extension method to convert a string to an unordered string
	extension (s: String)
		def u = unorderedString(s)
	
	// Phonemic String

	// A case class representing a phonemic string

	case class PhonemicString(var strt: String) {

		// Define the character mappings and unit lists for IPA and X-SAMPA conversion

		var caseList = List(
  			List('@', 'ə'), List('E', 'ɛ'), List('V', 'ʌ'), List('ae', 'æ'), List('I', 'ɪ'),
  			List('O', 'ɔ'), List('U', 'ʊ'), List('S', 'ʃ'),
  			List('Z', 'ʒ'), List('j', 'ʤ'), List('N', 'ŋ'), List('R', 'ʁ'), List('L', 'ɬ'),
  			List('x', 'χ'), List('B', 'β'), List('D', 'ð'), List('G', 'ɣ'), List('H', 'ɦ'),
  			List('F', 'ɸ'), List('P', 'ɸ'), List('Q', 'ʔ'), List('K', 'k'), List('T', 't'),
  			List('W', 'ʍ'), List('X', 'ɧ'), List('J', 'ʝ'), List('M', 'ɱ'), List('8', 'ɵ')
		)
		var unitList = List("tʃ", "dʒ", "ː")              //expand for more affricates
		var strIpa = strt
		var strXsampa = strt
		
		// Replace the characters in the input string with their IPA counterparts
		var i = 0;
		while(i < caseList.length){
			var tempL = caseList(i)
			strIpa = strIpa.replace(tempL(0),tempL(1))
			i = i + 1
		}

		// Replace the characters in the input string with their X-SAMPA counterparts
		// Seperate loops and extensions are used in this program for ease of editing and modularity
		i = 0;
		while(i < caseList.length){
			var tempL = caseList(i)
			strXsampa = strXsampa.replace(tempL(1),tempL(0))
			i = i + 1
		}

		// Calculate the length of the phonemic string, accounting for affricates
		var plength = strIpa.length()
		var count = 0;
		i = 0;
		while(i < unitList.length){
			count = count + strt.sliding(unitList(i).length()).count(_ == unitList(i))
			i = i + 1
		}	
		plength = plength - count;


		def toIPACase = strIpa
		def toXSampaCase = strXsampa
		def length = plength
		def ↓ = print(strt)
		def ↓| = print(strIpa)
		def ↓× = print(strXsampa)

		// Override the toString method to return the IPA representation
		override def toString = strIpa

		// Compare two phonemic strings for equality in IPA representation
		// Either =~ or ~= work, making it easier for the programmer.
		def =~(newStr: PhonemicString) = (strIpa == newStr.strIpa)
		def ~=(newStr: PhonemicString) = (strIpa == newStr.strIpa)
	}
	
		
	// Implicit conversion between String and PhonemicString
	given Conversion[String,PhonemicString] = n => PhonemicString(n)

	// Extension method to convert a string to a phonemic string
	extension (s: String)
		def / = PhonemicString(s)

	// Extension methods for printing line breaks
	extension (u: Unit)
		def ln = println("")

	extension (i: Int)
		def lines = for_loop(i){println("")}
	
	// flow control defination, loop helper methods.
	var i = 0;

	def for_loop(initializer: => Unit, condition: => Boolean, increment: => Unit)(body: => Unit) = {
		initializer
		while (condition) {
			body
			increment
		}
	}

	def for_loop(condition: => Int)(body: => Unit) = {
		i = 0
		while (i < condition) {
			body
			i += 1
		}
	}

	def for_loop(cond: => Boolean, increment: => Unit)(body: => Unit) = {
		i = 0
		while (cond) {
			body
			increment
		}
	}
	
	// Extension methods for conditional execution of statements
	extension(b: Boolean)
		def ⊢(statement: => Unit) = if (b) {statement}
		def ->(statement: => Unit) = if (b) {statement}
		def ->(statement: => Unit, elsestatement: => Unit) = if (b) {statement} else {elsestatement}
		def ⊢(statement: => Unit, elsestatement: => Unit) = if (b) {statement} else {elsestatement}
		
	// Extension method for running a block of code a specified number of times
	extension(i2: Int)
		def times(body: => Unit) = for_loop (i2) {body}

}

	
