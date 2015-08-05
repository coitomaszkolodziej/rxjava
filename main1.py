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

def generate(n):
    conn_string = "host='localhost' dbname='artistsandsongs' user='admin' password='admin'"
    print "Connecting to database\n	->%s" % (conn_string)
    conn = psycopg2.connect(conn_string)
    cursor = conn.cursor()

   
    with open('C:/Users/Praktyki/Desktop/bezzab/names.txt') as f:
        listOfNames = f.read().splitlines()
    with open('C:/Users/Praktyki/Desktop/bezzab/surnames.txt') as f:
        listOfSurnames = f.read().splitlines()
    for i in range(1, n+1):
        cursor.execute("INSERT INTO artists( artist_name, artist_surname, artist_age) VALUES(%s, %s, %s)", (unicode(random.choice(listOfNames), "utf-8"),
                                                                                                        unicode(random.choice(listOfSurnames), "utf-8"),
                                                                                                        unicode(str(random.randrange(20,80)), "utf-8")))

        k=random.randrange(1,5)
        with open('C:/Users/Praktyki/Desktop/bezzab/countries.txt') as f:
            listOfCountries = f.read().splitlines()
            for j in range(1, k+1):
                cursor.execute("INSERT INTO albums (album_name,artist_id) VALUES(%s,%s)", (unicode(random.choice(listOfCountries), "utf-8"),
                                                                                            i))
                cursor.execute("SELECT album_id from albums ORDER BY album_id DESC LIMIT 1 ")
                numberOfAlbums = cursor.fetchone()[0]

                o=random.randrange(1,10)
                with open('C:/Users/Praktyki/Desktop/bezzab/city-list.txt') as f:
                    listOfCities = f.read().splitlines()
                    for w in range(1, o+1):
                        cursor.execute("INSERT INTO songs (song_name,album_id) VALUES(%s,%s)", (unicode(random.choice(listOfCities), "utf-8"),
                                                                                            numberOfAlbums))

    cursor.close()
    conn.commit()
    conn.close()



generate(100)

#generateData()