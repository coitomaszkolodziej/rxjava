import random
import psycopg2
import sys

def makeConnection():
    connString = "host = 'localhost' dbname = 'artistsandsongs' user = 'admin'  password = 'admin'"
    conn = psycopg2.connect(connString)
    return conn

def clearArtists():
    conn = makeConnection()
    cursor = conn.cursor()
    cursor.execute("ALTER SEQUENCE artists_artist_id_seq RESTART WITH 1")
    cursor.execute("TRUNCATE artists CASCADE")
    cursor.close()
    conn.commit()
    conn.close()


def generateArtists(n):
    conn_string = "host='localhost' dbname='artistsandsongs' user='admin' password='admin'"
    print "Connecting to database\n	->%s" % (conn_string)
    conn = psycopg2.connect(conn_string)
    cursor = conn.cursor()

    namesFile = open("C:\\Users\Praktyki\Desktop\\imiona.txt", "r")
    surnamesFile = open("C:\\Users\\Praktyki\\Desktop\\nazwiska.txt", "r")
    #output = open("C:\Users\Praktyki\Desktop\\DIS_SEC\\output.txt", "w")
    listOfSurnames = [surname.rstrip('\n') for surname in surnamesFile.readlines() ]
    listOfNames = [ name.rstrip('\n') for name in namesFile.readlines()]

    for i in range(1, n+1):
     cursor.execute("INSERT INTO artists(artist_name, artist_surname, artist_age) VALUES(%s, %s, %s)",(random.choice(listOfNames),
                                                                                                       random.choice(listOfSurnames),random.randrange(20,80)))

    cursor.close()
    conn.commit()
    conn.close()
    surnamesFile.close()
    namesFile.close()


clearArtists()
generateArtists(100)
