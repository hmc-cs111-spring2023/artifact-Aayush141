# PP++ Documentation

Description: This code provides two case classes, PhonemicString and unorderedString, for working with phonemic and unordered strings, respectively. 

Additionally, it contains various utility methods for manipulating and comparing these new types.

The documentation and the project file are typically simultaneously updated, but some of it here might be out of date since the pppp.scala is constantly updated.  

## UnorderedString

The unorderedString case class represents an unordered string, where the characters are not ordered. 

Attributes:

toString: Returns the string representation of the unorderedString. The characters are sorted alphabetically.

~: Equality Operator. Compares two unorderedString instances for equality.

~=: Compares two unorderedString instances for equality, without considering duplicates.

-: Minus Operator. Removes characters from one unorderedString based on another unorderedString.

⊆: Checks if an unorderedString is a subset of another unorderedString.

⊇: Checks if an unorderedString is a superset of another unorderedString.

? or frequencyOf: Returns the number of a particular character in an unorderedString. (Similar to the indexOf for Strings)

Conversions and Extensions:

Conversion[String, unorderedString]: Converts a string to an unorderedString.

Conversion[unorderedString, String]: Converts an unorderedString to a string.

extension (s: String): Provides a u method for creating an unorderedString from a string.

var uos = "text" u   <---this creates an unordered string.

## PhonemicString

The PhonemicString type allows Linguists to work with phonemes.

**Attributes: **

In place of "upper case" and "lower case":

toIPACase: Converts the string to IPA case.

toXSampaCase: Converts the string to X-SAMPA case.

length: Returns the phonemic length of the string.

toString: Returns the IPA representation as a string.

=~ or ~=: Compares two PhonemicString instances for equality. 

↓  : Used to print the phoneme. IO operator

↓| : Prints the phoneme in IPA case. IO operator

↓× : Prints the phoneme in Xsampa case. IO operator

Conversions and Extensions:

Any String implicitly converts to a PhonemicString when 

extension (s: String): Provides a / method for creating a PhonemicString from a string.


## Utility Methods

This code also contains utility methods for looping and working with strings:

for_loop:

for loops are used when you have a block of code which you want to repeat a fixed number of times.

var i = 0;\
for_loop(10) { \ 
  println(i)\
}

for_loop(i < 10, i += 1) {\
  println(i)\
}

for_loop((i = 0), i < 10, i += 1) {\
  println(i);\
}

These allow the programmer to work with and parse through the new datatypes.

Implication function: 

A -> B : if A then B. 

n times {block}: 

repeats a block of code "n" times.

line or lines or ln: prints empty lines.

