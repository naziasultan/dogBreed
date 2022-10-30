CREATE TABLE IF NOT EXISTS dog (metadata json default '{}', PRIMARY KEY (id) );

CREATE TABLE IF NOT EXISTS image (
   imageUrl json default '{}',
   PRIMARY KEY (id)
 );
