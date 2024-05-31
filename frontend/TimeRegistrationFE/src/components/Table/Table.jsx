import { useMemo } from "react";
import { useSortBy, useTable } from "react-table";

const Table = ({columns, data}) => {

    const memoizedColumns = useMemo(() => columns, [columns])
    const memoizedData = useMemo(() => data, [data])

    const { getTableProps, getTableBodyProps, headerGroups, rows, prepareRow } = useTable({
        columns: memoizedColumns,
        data: memoizedData
    },
        useSortBy
    )

    return (
        <div className="Container">
        <table {...getTableProps()}>
            <thead>
                {headerGroups.map(headerGroup =>(
                <tr {...headerGroup.getHeaderGroupProps()} key={headerGroup}>
                    {headerGroup.headers.map(column => (
                            <th {...column.getHeaderProps(column.getSortByToggleProps())} key={column}>
                                {column.render("Header")}
                                <span>
                                    {column.isSorted ? (column.isSortedDesc ? "" : "") : ""}
                                </span>

                            </th>
                        ))}
                </tr>
                ))}
            </thead>

            <tbody {...getTableBodyProps()}>
                {rows.map(row => {
                    prepareRow(row)
                    return (
                        <tr {...row.getRowProps()} key={row}>
                            {row.cells.map(cell => {
                                return <td {...cell.getCellProps()} key={cell.column}>
                                    {cell.render("Cell")}</td>
                            })}
                        </tr>
                    )
                })}
            </tbody>
        </table>
        </div>
    )
}

export default Table