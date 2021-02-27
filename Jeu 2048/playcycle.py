#!/usr/bin/env python
# coding: utf-8

# In[1]:


import sys
sys.path.append("../Tiles")
sys.path.append("../Ui")
sys.path.append("../Game")
import json
import os.path
from play import *
from tiles_moves import *
from tiles_acces import *
from play_display import *
from user_entries import *


# In[2]:


def cycle_play(partie):
    if partie is None:
        return False
    """Permet de jouer à Threes, prend en paramètre une partie ou None"""
    
    while partie['next_tile']['check']:
        medium_display(partie['plateau'])
        if not partie['next_tile']['check']:
            return True
        val=partie['next_tile']['t1']['val']

        print("valeur de la prochaine tuile : "+str(val))
        move=get_user_move()
        if move=='m':
        
            return False
        else:
            play_move(partie['plateau'],move)
            partie['next_tile']=get_next_alea_tiles(partie['plateau'],'encours')
            partie['next_tile']['t1']['val']=val
            put_next_tiles(partie['plateau'],partie['next_tile'])
            partie['next_tile']=get_next_alea_tiles(partie['plateau'],'encours')
            partie['score']=get_score(partie['plateau'])
        if not partie['next_tile']['check']:
            return True
    return True


# In[3]:


partie=create_new_play(1)


# In[ ]:





# In[4]:


test=cycle_play(partie)


# In[ ]:





# In[4]:


def save_game(partie):
    """Save une game au format Json dans saved_game.json"""
    
    fichier = open ("saved_game.json","w")
    json.dump(partie,fichier)
    fichier.close()
    


# In[5]:


def restore_game():
    """permet de restaurer une game saved ou d'en créer une nouvelle si il n'y a pas de save"""
    if os.path.exists("saved_game.json"):
        fichier = open ("saved_game.json","r")
        load=fichier.read()
        partie=json.loads(load)
        fichier.close()
    else:
        partie=create_new_play(1)
    return partie


# In[13]:


p1=create_new_play(1)
save_game(p1)
p2=restore_game()
print(p2['next_tile']['0']['val'])


# In[31]:




