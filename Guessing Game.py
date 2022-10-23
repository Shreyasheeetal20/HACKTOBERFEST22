import random

num = random.randint(1,100)

print("WELCOME TO GUESS ME!")
print("I'm thinking of a number between 1 and 100")
print("If your guess is more than 10 away from my number, I'll tell you you're COLD")
print("If your guess is within 10 of my number, I'll tell you you're WARM")
print("If your guess is farther than your most recent guess, I'll say you're getting COLDER")
print("If your guess is closer than your most recent guess, I'll say you're getting WARMER\n\n")
print("LET'S PLAY!\n\n")

guesses = [0]

while True:

    guess = int(input("Guess a number between 1 and 100.\nEnter your guessed number. "))
    
    if guess < 1 or guess > 100:
        print('OUT OF BOUNDS! Please try again: ')
        continue

    if guess == num:
        print(f'CONGRATULATIONS, YOU GUESSED IT IN ONLY {len(guesses)} GUESSES!!')
        break
        
    guesses.append(guess)
    
    
    if guesses[-2]:  
        if abs(num-guess) < abs(num-guesses[-2]):
            print('WARMER!\n')
        else:
            print('COLDER!\n')
   
    else:
        if abs(num-guess) <= 10:
            print('WARM!\n')
        else:
            print('COLD!\n')