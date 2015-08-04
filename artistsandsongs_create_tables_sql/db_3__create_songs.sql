  
  CREATE TABLE songs
(
  song_id serial PRIMARY KEY,
  song_name VARCHAR(250),
  album_id integer,
  CONSTRAINT fk_album_id FOREIGN KEY (album_id) REFERENCES
  albums(album_id) ON UPDATE CASCADE ON DELETE CASCADE
 )