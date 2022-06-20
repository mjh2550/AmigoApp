package com.android.amigo.data.board

data class Board(
    val board_idx : String,
    val board_title : String,
    val board_contents : String,
    val read_count  : Int,
    val notice_flag : String,
    val insert_user : String,
    val insert_time : String,
    val insert_ip : String
)
/**
 * amigo_board
 * board_idx      | varchar(100)  | NO   | PRI | NULL
board_title    | varchar(100)  | NO   |     | NULL
board_contents | varchar(3000) | YES  |     | NULL
read_count     | int           | YES  |     | 0
notice_flag    | varchar(2)    | YES  |     | NULL
insert_user    | varchar(50)   | YES  |     | NULL
insert_time    | varchar(20)   | YES  |     | NULL
insert_ip      | varchar(20)   | YES  |     | NULL
 */


