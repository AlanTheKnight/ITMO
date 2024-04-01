import pandas as pd
import plotly.graph_objs as go

df = pd.read_csv("data.csv")

columns = [
    ("<OPEN>", "Открытие"),
    ("<CLOSE>", "Закрытие"),
    ("<HIGH>", "Макс"),
    ("<LOW>", "Мин"),
]

dates = df["<DATE>"].unique()

fig = go.Figure()
for date in dates:
    subdf = df[df["<DATE>"] == date]

    for col_col, col_title in columns:
        fig.add_trace(go.Box(y=subdf[col_col], name=date + " - " + col_title))

fig.update_layout(title="Биржевые данные за сентябрь-декабрь 2018")
fig.show()
