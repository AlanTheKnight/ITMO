SOLUTION_FILENAME=./solution/solution.sh

if [ -f $SOLUTION_FILENAME ]; then
    rm $SOLUTION_FILENAME
fi

touch $SOLUTION_FILENAME

for i in $(seq 5); do
    if [ $i = 1 ]; then
        cat ./solution/lab-1-1.sh | head -n 1 >./solution/solution.sh
    fi

    echo "" >>$SOLUTION_FILENAME
    echo "########################" >>$SOLUTION_FILENAME
    echo "# Пункт $i              #" >>$SOLUTION_FILENAME
    echo "########################" >>$SOLUTION_FILENAME

    FILENAME=solution/lab-1-$i.sh
    file_length=$(wc -l <$FILENAME)
    cat $FILENAME | tail -n $(($file_length - 1)) >>$SOLUTION_FILENAME
done

chmod +x $SOLUTION_FILENAME
