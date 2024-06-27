ORG 0x0358
TEST_PASSED: WORD 0x0000
ARG1: WORD 0x0000
ARG2: WORD 0xFFFF
ARG3: WORD 0x00FA
EXP1: WORD 0x00AB
EXP2: WORD 0x0009
EXP3: WORD 0x01B5
RES1: WORD 0x0000
RES2: WORD 0x0000
RES3: WORD 0x0000

        ORG 0x036C
START:  CLA
        ST TEST_PASSED
        JUMP TEST1

STOP:   LD TEST_PASSED
        HLT

TEST1:  LD ARG1
        PUSH
        WORD 0x0FAB ; ADDSPC 0xAB
        ST RES1
        POP
        LD RES1
        CMP EXP1        ; Compare to expected result
        BNE STOP        ; Stop if there's error
        LD TEST_PASSED  ; Increment test counter
        INC
        ST TEST_PASSED
TEST2:  LD ARG2
        PUSH
        WORD 0x0F0A ; ADDSPC 0x0A
        ST RES2
        POP
        LD RES2
        CMP EXP2        ; Compare to expected result
        BNE STOP        ; Stop if there's error
        LD TEST_PASSED  ; Increment test counter
        INC
        ST TEST_PASSED
TEST3:  LD ARG3
        PUSH
        WORD 0x0FBB ; ADDSPC 0xBB
        ST RES3
        POP
        LD RES3
        CMP EXP3        ; Compare to expected result
        BNE STOP        ; Stop if there's error
        LD TEST_PASSED  ; Increment test counter
        INC
        ST TEST_PASSED
        HLT
END
