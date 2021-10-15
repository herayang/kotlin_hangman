import java.io.File
import java.util.*
import java.util.regex.Pattern

class Hangman() {

    /**
     * Reads textfile and adds it in to the possible random word list.
     * */
    fun readFile(fileName:String, blankarr: ArrayList<String>){
        File(fileName).forEachLine{
            blankarr.add(it)
        }
    }

    /**
     * checks user's input.
     * */
    fun inputValidation(): Char {
        var invalid = true
        var guess = ""
        val guessLetter: Char
        while (invalid) {
            println()
            print("Please guess a letter: ")
            val scanner = Scanner(System.`in`)
            guess = scanner.nextLine()
            if (guess.length > 1 || guess.length == 0) {
                println("Please enter a single character")
            } else {
                val p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE)
                val m = p.matcher(guess)
                val ISspecialCharacter = m.find()
                if (ISspecialCharacter) {
                    println("Please enter letters without special characters") //fix this to say something like specified range.
                } else {
                    guess = guess.toLowerCase()
                    invalid = false
                }

            }
        }
        guessLetter = guess[0]
        return guessLetter
    } // end of InputValidation

    /**
     * Generates random number.
     * */
    fun randomNum(): Int {
        val random = Random()
        return random.nextInt(6344)
    }

    /**
     * Picks a word from the worst list with given index number.
     * */
    fun chosenWord(list: ArrayList<String>, num: Int): String {
        return list[num]
    }

    /**
     * fills the given array with the string.
     * */
    fun wordToArray(blankarr: ArrayList<String>, word: String): ArrayList<String> {
        val length = word.length

        for (i in 0 until length) {
            val stringChar = Character.toString(word[i])
            blankarr.add(stringChar)
        }
        return blankarr
    }

    /**
     * Beginning game prep (empty spaces to represent number of letters)
     * */
    fun gamePrep(blank: ArrayList<String>, word: String): ArrayList<String> {
        val length = word.length
        var counter = 0
        //System.out.println(word);

        while (counter < length) {
            blank.add("_")
            counter++
        }
        return blank
    } // End of gamePrep

    /**
     * Helper function that prints an array
     * */
    fun printArray(list: ArrayList<String>) {
        for (i in list.indices) {
            print(list[i] + " ")
        }
    }

}


