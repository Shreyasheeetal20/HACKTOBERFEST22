import random as rand
import time
import sys

file = open('allpokemon.txt', 'r')
all_pokemon = file.readlines()

owned_pokemon = []

while True:
	oldsave = input('Do you have a save file? (y/n)')
	if oldsave.lower().strip() == 'n':
		print('\nWelcome!')
		break
	if oldsave.lower().strip() == 'y':
		print('\nWelcome back! Add your save file path below! (owned pokemon)')
		own_file = input()
		try:
			own_file_start = open(own_file, 'r')
			owned_pokemon = [pokemon.strip() for pokemon in own_file_start.readlines()]
			own_file_start.close()
			print('\nAll set!')
			break
		# file doesn't exist.
		except FileNotFoundError:
			print('We had a problem processing your files, try again or start new!')
		
while True:
	print('\nA pokemon has appeared!\n')

	current_pokemon = rand.choice(all_pokemon).strip().upper()

	# \n is an escape character which moves on to the next line. I feel like this helps the output stay organized. 
	# Again, whether you want to include this is entirely up to you!
	print("It's a", current_pokemon + '!\n\n')

	catches_left = 3

	while True:
		catch_state = input('Would you like to catch it? (y/n)')
		if catch_state.lower() == 'y' or catch_state.lower() == 'yes':
			# no more catches left:
			if catches_left <= 0:
				print('You weren\'t able to catch the pokemon. ')
				break
			else:
				catch = rand.randint(1, 100)
				if catch <= 33:
					owned_pokemon.append(current_pokemon)
					if owned_pokemon not in owned_pokemon:
						print('\n\nYou got a new Pokemon!\n\nAdding it to the pokedex...')
					break
				
				else:
					catches_left -= 1
					print('\nIt jumped out, try again!')

		elif catch_state.lower() == 'n' or catch_state.lower() == 'no':
			print('Bye', current_pokemon + '!')
			break

		else:
			print('\nValid input is y, yes, n, or no')

	print('\n\nWould you like to see owned pokemon or your pokedex?\n')
	print('O = Owned Pokemon')
	print('P = Pokedex')
	print('U = Update both to a file!')
	print('N = Exit')
	print('S = Exit Program\n')
	while True:
		choice = input('Pick your choice!')
		if choice.lower() == 'o':
			print(owned_pokemon)
		if choice.lower() == 'p':
			print(set(owned_pokemon))
		if choice.lower() == 'u':
			print('Working on it!')
			# create file
			owned_pokemon_file = open('owned_pokemon.txt', 'w')

			# for every caught pokemon
			for i in owned_pokemon:
				# write it to a file and split pokemon with new lines
				owned_pokemon_file.write(i + '\n')

			# close to save
			owned_pokemon_file.close()

			# same for pokedex
			pokedex_file = open('pokedex.txt', 'w')
			for i in set(owned_pokemon):
				pokedex_file.write(i + '\n')
			pokedex_file.close()

			print('\nDone! View them in your explorer tab.')
		if choice.lower() == 'n':
			break
		if choice.lower() == 's':
			sys.exit()
	
	print('\n\nWait for a new pokemon...')
	time.sleep(rand.randint(5, 10))
	
