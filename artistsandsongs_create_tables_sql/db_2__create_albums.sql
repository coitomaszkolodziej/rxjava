CREATE TABLE albums
(
  album_id SERIAL PRIMARY KEY NOT NULL,
  album_name VARCHAR(250),
  artist_id integer,
  CONSTRAINT fk_artist_id FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
  ON UPDATE CASCADE ON DELETE CASCADE
)
