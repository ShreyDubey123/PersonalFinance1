import React from 'react'

const CatInvestmentBar = () => {
    return (
        <div>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item col-4" role="presentation">
                    <button class="nav-link active col-12" id="daily-tab" data-bs-toggle="tab" data-bs-target="#daily-tab-pane" type="button" role="tab" aria-controls="daily-tab-pane" aria-selected="true">Daily</button>
                </li>
                <li class="nav-item col-4" role="presentation">
                    <button class="nav-link col-12" id="weekly-tab" data-bs-toggle="tab" data-bs-target="#weekly-tab-pane" type="button" role="tab" aria-controls="weekly-tab-pane" aria-selected="false">Weekly</button>
                </li>
                <li class="nav-item col-4" role="presentation">
                    <button class="nav-link col-12" id="monthly-tab" data-bs-toggle="tab" data-bs-target="#monthly-tab-pane" type="button" role="tab" aria-controls="monthly-tab-pane" aria-selected="false">Monthly</button>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">...</div>
                <div class="tab-pane fade" id="weekly-tab-pane" role="tabpanel" aria-labelledby="weekly-tab" tabindex="0">...</div>
                <div class="tab-pane fade" id="monthly-tab-pane" role="tabpanel" aria-labelledby="monthly-tab" tabindex="0">...</div>
            </div>
        </div>
    )
}

export default CatInvestmentBar
