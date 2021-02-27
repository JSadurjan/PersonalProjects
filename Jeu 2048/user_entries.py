#!/usr/bin/env python
# coding: utf-8

# In[2]:


def get_user_move():
    """Saisie et retourne le coup joué par le joueur parmi les choix"""
    move=0
    while move!='g' and move!='d' and move !='h' and move!='b' and move!='m' :
        print("Saisir 'h' pour haut, 'b' pour bas, 'g' pour gauche ou 'd' pour droite")
        move=str(input("Choisissez le coup à jouer\n"))
        move=move.lower()
    return move


# In[7]:


def get_user_menu(partie):
    """Menu principal pour le joueur:
    N pour nouvelle partie
    L pour charger une partie
    S pour sauvegarder la partie en cours
    C pour charger la partie en cours
    Q pour quitter le jeu"""
    instruc=""
    if partie is None:
        while instruc!="N" and instruc!="L" and instruc!='Q':
            instruc=input("Que voulez-vous faire ?\nN : New Game\nL : Load a Game Save\nQ : Quit")
            instruc=instruc.upper()
    else:      
        while instruc!="N" and instruc!="L" and instruc!="S" and instruc!="S" and instruc!="C" and instruc!="Q":
            instruc=input("Que voulez-vous faire ?\nN : New Game\nL : Load a Save\nS : Save\nC : Resume\nQ : Quit\n")
            instruc=instruc.upper()
    return instruc


# In[8]:




