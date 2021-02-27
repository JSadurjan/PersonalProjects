#!/usr/bin/env python


import sys
sys.path.append("../tiles")
sys.path.append("../game")
sys.path.append("../ui")
import json 
from tiles_moves import *
from tiles_acces import *
from play_display import *
from play import *
from user_entries import *

def cycle_play(partie):
    if partie is None:
        return False
    """Permet de jouer à Threes, prend en paramètre une partie ou None"""
    
    while partie['next_tile']['check']:
        full_display(partie['plateau'])
        
        val=partie['next_tile']['t1']['val']
        
        print("valeur de la prochaine tuile : "+str(partie['next_tile']['t1']['val']))
        move=get_user_move()
        if move=='m':

            return False
        else:
            play_move(partie['plateau'],move)
            partie['next_tile']=get_next_alea_tiles(partie['plateau'],'encours')
            set_value(partie['plateau'],partie['next_tile']['t1']['lig'],partie['next_tile']['t1']['col'],val)
            partie['score']=get_score(partie['plateau'])
        if not partie['next_tile']['check']:
            return True

def save_game(partie):
    
    fichier = open ("saved_game.json","w")
    json.dump(partie,fichier)
    fichier.close()

def restore_game():

    if os.path.exists("saved_game.json"):
        fichier = open ("saved_game.json","r")
        load=fichier.read()
        partie=json.loads(load)
        fichier.close()
    else:
        partie=create_new_play(1)
    return partie