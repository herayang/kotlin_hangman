import java.util.*

fun main(args: Array<String>){

    val hangman = Hangman()
    var wordlist = ArrayList<String>(50)

    hangman.readFile("word-list.txt", wordlist)
    var triedletters = ArrayList<String>(50)
    var game = true

    val randomWord = hangman.chosenWord(wordlist, hangman.randomNum())

    val play = ArrayList<String>(randomWord.length)
    val wordArr = ArrayList<String>(randomWord.length)

    // Game explanation:
    println("Guess the word before this program laughs at you with a shrug emoji.")
    hangman.wordToArray(wordArr, randomWord)
    hangman.gamePrep(play, randomWord)
    hangman.printArray(play)
    var strike = 0

    println()

    while (game) {
        val tries = hangman.inputValidation()

        if (randomWord.contains(tries)) {
            val stringtries = Character.toString(tries)
            // letter was already tried.
            if (triedletters.contains(stringtries)) {
                println()
                println("The letter is already filled in! Please try another letter.")
            }
            //new letter.
            else {
                println("$tries is in the word")
                for (i in 0 until randomWord.length) {
                    if (randomWord[i] == tries) {
                        play.set(i, stringtries)
                        triedletters.add(stringtries)
                    }
                }
            }
            println()
            hangman.printArray(play)
        }
        //letter not found in the word.
        else {
            println("$tries is not in the word.")
            strike++
            println("wrong guesses: $strike /9")
            println()
            hangman.printArray(play)
        }
        when (strike) {
            1 -> println("Shrug emoji status: \n -")
            2 -> println("Shrug emoji status: \n -\\")
            3 -> println("Shrug emoji status: \n ¯\\_")
            4 -> println("Shrug emoji status: \n ¯\\_(")
            5 -> println("Shrug emoji status: \n ¯\\_(ツ")
            6 -> println("Shrug emoji status: \n ¯\\_(ツ)")
            7 -> println("Shrug emoji status: \n ¯\\_(ツ)_")
            8 -> println("Shrug emoji status: \n ¯\\_(ツ)_/")
            9 -> {
                println("Shrug emoji status: \n ¯\\_(ツ)_/¯")
                println("You Lose!")
                println("The word was $randomWord")
                game = false
            }
        }
        if (play == wordArr) {
            println()
            println("You Win!")
            game = false
        }
    }



}