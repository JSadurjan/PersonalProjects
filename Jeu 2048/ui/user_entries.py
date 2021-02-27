#!/usr/bin/env python


import sys
sys.path.append("../tiles")
sys.path.append("../game")
sys.path.append("../life-cycle")

from tiles_moves import *
from tiles_acces import *
from play_display import *
from play import *

def get_user_move():
    """Saisie et retounre le coup joué par le joueur parmi les choix"""
    move=-1
    while move!='g' and move!='d' and move !='h' and move!='b' and move!='m' :
        move=str(input("Choisissez le coup à jouer\n"))
        move=move.lower()
    return move

def get_user_menu(partie):

    instruc=""
    if partie is None:
        while instruc!="N" and instruc!="L" and instruc!='Q':
            instruc=input("Que voulez-vous faire ?\nN : New Game\nL : Load a Save\nQ : Quit")
            instruc=instruc.upper()
    else:      
        while instruc!="N" and instruc!="L" and instruc!="S" and instruc!="S" and instruc!="C" and instruc!="Q":
            instruc=input("Que voulez-vous faire ?\nN : New Game\nL : Load a Save\nS : Save\nC : Resume\nQ : Quit\n")
            instruc=instruc.upper()
    return instruc