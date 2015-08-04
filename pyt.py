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

def clearAlbums():
    conn = makeConnection()
    cursor = conn.cursor()
    cursor.execute("ALTER SEQUENCE albums_album_id_seq RESTART WITH 1")
    cursor.execute("TRUNCATE albums CASCADE")
    cursor.close()
    conn.commit()
    conn.close()

def clearSongs():
    conn = makeConnection()
    cursor = conn.cursor()
    cursor.execute("ALTER SEQUENCE songs_song_id_seq RESTART WITH 1")
    cursor.execute("TRUNCATE songs CASCADE")
    cursor.close()
    conn.commit()
    conn.close()

def generateArtists(n):
    conn = makeConnection()
    cursor = conn.cursor()

    namesFile = open("C:\\Users\Praktyki\Desktop\\imiona.txt", "r")
    surnamesFile = open("C:\\Users\\Praktyki\\Desktop\\nazwiska.txt", "r")
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


def generateAlbums(n):
    conn_string = "host='localhost' dbname='artistsandsongs' user='admin' password='admin'"
    print "Connecting to database\n	->%s" % (conn_string)
    conn = psycopg2.connect(conn_string)
    cursor = conn.cursor()

    print "Connected to Albums!\n"
    with open('C:/Users/Praktyki/Desktop/countries.txt') as f:
        listOfCountries = f.read().splitlines()
    cursor.execute("SELECT COUNT(artist_name) FROM ARTISTS")
    k=cursor.fetchall()
    for i in range(1, n+1):
        cursor.execute("INSERT INTO albums (album_name,artist_id) VALUES(%s,%s)", (unicode(random.choice(listOfCountries), "utf-8"),
                                                                                   unicode(str(random.randrange(1,k[0][0])), "utf-8")))

    cursor.close()
    conn.commit()
    conn.close()

def generateSongs(n):
    conn = makeConnection()
    songsFile = open("C:\\Users\Praktyki\Desktop\city-list.txt", "r")
    listOfSongs = [song.rstrip('\n') for song in songsFile.readlines()]
    cursor = conn.cursor()
    cursor.execute("SELECT album_id from albums ORDER BY album_id DESC LIMIT 1 ")
    numberOfAlbums = cursor.fetchone()[0]

    for i in range(0, n):
        cursor.execute("INSERT INTO songs (song_name, album_id) VALUES (%s, %s) ", (random.choice(listOfSongs), random.randrange(1, numberOfAlbums)))

    cursor.close()
    conn.commit()
    conn.close()

clearArtists()
clearAlbums()
clearSongs()
generateArtists(100)
#generateAlbums(200)
generateSongs(300)